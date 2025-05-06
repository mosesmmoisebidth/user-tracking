package moses.project.com.moses.modules.cloudinary;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.*;


@Service
public class CloudinaryService {

    @Value("${spring.cloudinary.folder}")
    private String folder;

    @Autowired private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
            "folder", folder,
            "resource_type", "image",
            "format", "jpg"
        ));
        return (String) result.get("secure_url");
    }

    public List<String> uploadFiles(List<MultipartFile> files) throws IOException {
        List<String> results = new ArrayList<>();
        for(MultipartFile file: files){
            results.add(uploadFile(file));
        }
        return results;
    }




}
