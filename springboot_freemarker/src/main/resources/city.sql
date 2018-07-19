
drop table city;

create table city (
    id BIGINT(20) NOT NULL,
    province_id BIGINT(20) NOT NULL,
    city_name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    PRIMARY KEY(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into city (id, province_id, city_name, description) values(1000, 2000, "NJ", "NanJing is a beautiful city");
insert into city (id, province_id, city_name, description) values(1001, 3000, "BJ", "BeiJing is a good city");