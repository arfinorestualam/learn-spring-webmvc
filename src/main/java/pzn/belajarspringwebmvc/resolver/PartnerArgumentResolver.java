package pzn.belajarspringwebmvc.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import pzn.belajarspringwebmvc.model.Partner;

//make custom Argument Resolver
//argument resolver is background check where to find the data that needed

@Component
//must implements Handler Method Argument Resolver
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //this method for checking the parameter is support or not
        return parameter.getParameterType().equals(Partner.class);
    }

    @Override
    //if yes then this method is called
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String apiKey = request.getHeader("X-API-KEY");
        if (apiKey != null) {
            //query to database
            return new Partner(apiKey, "Sample Partner");
        }
        throw new RuntimeException("Unauthorized Exception");
    }
}
