package org.lyh.dblog.cgi.resource;

import org.lyh.dblog.cgi.bean.ResultBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author lvyahui
 * @since 2016/9/13 14:23.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    @ResponseBody
    public ResultBody file(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        ResultBody result = new ResultBody();
        if(file != null && !file.isEmpty()){
            try {
                String path = request.getServletContext()
                        .getRealPath("/").concat("/uploads/").concat(file.getOriginalFilename());
                File saveFile = new File(path);
                File dir = saveFile.getParentFile();
                if(!dir.exists()){
                    if(!dir.mkdirs()){
                        result.setCode(1).setMsg("write error");
                        return result;
                    }
                }
                file.transferTo(saveFile);
                result.put("url",request.getContextPath()+"/uploads/"+file.getOriginalFilename());
            } catch (IOException e){
                result.setCode(1).setMsg(e.getMessage());
            }
        }
        return result;
    }
}
