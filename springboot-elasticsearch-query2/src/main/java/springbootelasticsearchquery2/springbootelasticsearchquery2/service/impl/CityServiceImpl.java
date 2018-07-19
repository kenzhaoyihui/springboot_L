package springbootelasticsearchquery2.springbootelasticsearchquery2.service.impl;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import springbootelasticsearchquery2.springbootelasticsearchquery2.domain.City;
import springbootelasticsearchquery2.springbootelasticsearchquery2.repository.CityRepository;
import springbootelasticsearchquery2.springbootelasticsearchquery2.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    /* 分页参数 */
    Integer PAGE_SIZE = 12; //the numbers of per page
    Integer DEFAULT_PAGE_NUMBER = 0; //default the current page


    /* 搜索模式 */
    String SCORE_MODE_SUM = "sum"; //权重分求和模式
    Float MIN_SCORE = 10.0F; //由于无相关性的分值默认为 1 ，设置权重分最小值为 10


    @Autowired
    CityRepository cityRepository;

    @Override
    public Long saveCity(City city) {
        //return null;
        City cityResult = cityRepository.save(city);
        return cityResult.getId();

    }

    @Override
    public List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent) {

        //return null;
        if (pageSize == null || pageSize <= 0) {
            pageSize = PAGE_SIZE;
        }

        if (pageNumber == null || pageNumber <= DEFAULT_PAGE_NUMBER) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        logger.info("\n searchCity: searchContent [" + searchContent + "] \n");

        SearchQuery searchQuery = getCitySearchQuery(pageNumber, pageSize, searchContent);

        logger.info("\n searchCity: searchContent [" + searchContent + "] \n DSL = \n" +
                searchQuery.getQuery().toString());

        Page<City> cityPage = cityRepository.search(searchQuery);

        return cityPage.getContent();

    }

    /**
     * 根据搜索词构造搜索查询语句
     * 代码流程：
     *      - 权重分查询
     *      - 短语匹配
     *      - 设置权重分最小值
     *      - 设置分页参数
     *
     * @param pageNumber current pageNumber
     * @param pageSize   size of per page
     * @param searchContent  search content
     * @return
     */
    private SearchQuery getCitySearchQuery(Integer pageNumber, Integer pageSize, String searchContent) {

        // 短语匹配到的搜索词，求和模式累加权重分
        // 权重分查询 https://www.elastic.co/guide/cn/elasticsearch/guide/current/function-score-query.html
        //   - 短语匹配 https://www.elastic.co/guide/cn/elasticsearch/guide/current/phrase-matching.html
        //   - 字段对应权重分设置，可以优化成 enum
        //   - 由于无相关性的分值默认为 1 ，设置权重分最小值为 10


        // here is elasticsearch version 2.4.6
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(500))
                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);

//        Pageable pageable = new PageRequest(pageNumber, pageSize);  //deprecated
        Pageable pageable = new QPageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder)
                .build();


        /**
         * elasticsearch 5.6.10 need to the FilterFunctionBuilder
         * FunctionScoreQueryBuilder
         * 添加方法已删除，所有过滤器和函数必须作为构造函数参数提供，方法是创建一个FunctionScoreQueryBuilder.FilterFunctionBuilder对象数组，每个过滤器/函数对包含一个元素。
         *
         * scoreMode和boostMode只能使用相应的枚举成员而不是字符串值提供：请参阅FilterFunctionScoreQuery.ScoreMode和CombineFunction。
         *
         * CombineFunction.MULT已重命名为MULTIPLY。
         */
//
//        FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[3];
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(filterFunctionBuilders);
//        return null;

    }
}

