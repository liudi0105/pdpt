package com.pt.server.language;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class C implements AttributeConverter<LanguageEntity.TransState, String> {

    @Override
    public String convertToDatabaseColumn(LanguageEntity.TransState attribute) {
        return attribute.getCode();
    }

    @Override
    public LanguageEntity.TransState convertToEntityAttribute(String dbData) {
        return Arrays.stream(LanguageEntity.TransState.values()).filter(v -> v.getCode().equals(dbData)).findAny().orElse(null);
    }
}
