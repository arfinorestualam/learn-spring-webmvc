package pzn.belajarspringwebmvc.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//converter di buat dimana belum ada converternya, jadi nanti ketika di tes
//otomatis dicarikan converternya
@Slf4j
@Component
public class StringToDateConverter implements Converter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            log.warn("error parsing date from string: {}", source, e);
            return null;
        }
    }
}
