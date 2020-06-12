package com.raphael.api.ApiSybase.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateUtil {

    public String fotmatDateDataBase(LocalDate localDate){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
    }
}
