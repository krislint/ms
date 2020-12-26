package com.moelyon.ms.provider.service.impl;

import com.moelyon.ms.api.service.WordListService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * wordList
 *
 * @author : wlt
 * @date : 2020-12-22 20:54
 **/
//@Component
@DubboService
public class WordListServiceImpl implements WordListService {
    @Override
    public List<String> getCharList(String str) {
        List<String> list = new ArrayList<>(str.length());
        for(char c: str.toCharArray()){
            list.add(Character.toString(c));
        }

        return list;
    }
}
