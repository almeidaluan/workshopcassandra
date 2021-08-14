package com.sample.workshopcassandra.util;


import java.time.LocalDateTime;

public interface IDateUtil {
    String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime);
}
