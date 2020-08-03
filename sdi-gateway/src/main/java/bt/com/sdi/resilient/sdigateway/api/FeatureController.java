package bt.com.sdi.resilient.sdigateway.api;

import bt.com.sdi.resilient.sdigateway.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FeatureController {

    @Autowired
    public FeatureService featureService;

    @RequestMapping(value = "/feature/{id:.+}/redirect")
    public void featureRedirect(@PathVariable String id, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", featureService.getFeature(id));
        httpServletResponse.setStatus(302);
    }

    @RequestMapping(value = "/feature/{id:.+}")
    public String feature(@PathVariable String id) {
        return featureService.getFeature(id);
    }
}
