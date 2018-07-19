package springboot_uploadfile.springboot_uploadfile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot_uploadfile.springboot_uploadfile.storage.StorageFileNotFoundException;
import springboot_uploadfile.springboot_uploadfile.storage.StorageService;

import java.util.stream.Collectors;


@Controller
public class FileUploadController {

//    private final StorageService storageService;
//
//    @Autowired
//    public FileUploadController(StorageService storageService) {
//        this.storageService = storageService;
//    }

    // 注入 storageService bean
    @Autowired
    StorageService storageService;

    // 上传文件列表
    @GetMapping("/")
    public String listUploadFiles(Model model) {
        // loadAll 方法返回一个 Stream<Path> 集合
        // Stream 是 Java 8 中对集合 Collection 的增强, 结合 lambda 用函数式编程对集合进行复杂的操作 ( 查找、遍历、过滤等)

        // 解析这一行看起来复杂的代码
        // Stream.map 将一个 Stream 使用给定的转换函数 （Lambda） 映射为一个新的 Stream
        // 参数 path 即为 Stream<Path> 中的 Path
        // fromMethodName 方法创建一个 UriComponentsBuilder 对象 (通过 controller 方法名上的 mapping 路径与参数组数)
        // 返回的 UriComponentsBuilder 的 build 方法 创建一个 UriComponents 对象, 最后将 UriComponents 转换为字符串
        // Stream.collect 方法将 map 转换后的新 Stream 变为 list 返回给模板
        // 这一系列操作，实际上就是为了把 Stream<Path> 转换为一个存储 url 字符串的列表对象

        model.addAttribute("files", storageService
            .loadAll()
            .map(path -> MvcUriComponentsBuilder
            .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
            .build().toString())
            .collect(Collectors.toList()));

        return "uploadForm";
    }

    // 文件下载
    // 正则表达式匹配, 语法: {varName:regex} 前面式变量名，后面式表达式
    // 匹配出现过一次或多次.的字符串 如: "xyz.png"
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

    }
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity
//                .ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
//                .body(file);
//}


    // 处理上传逻辑
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        // 保存文件
        storageService.store(file);

        // 使用 RedirectAttributes 添加一个重定向参数
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }


    // 统一处理该 controller 异常
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
