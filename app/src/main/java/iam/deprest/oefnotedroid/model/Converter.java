package iam.deprest.oefnotedroid.model;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Converter {

    @TypeConverter
    public static Date fromString(String input){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault());
        try {
            return simpleDateFormat.parse(input);
        }catch (ParseException e){
            return null;
        }
    }

    @TypeConverter
    public static String fromDate(Date input){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault());
        return simpleDateFormat.format(input);
    }
}
