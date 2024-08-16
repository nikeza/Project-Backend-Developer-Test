package com.serviceshuffle.service;

import com.serviceshuffle.dto.NumberDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NumberServiceImpl implements NumberService{

    @Override
    public List<Integer> shuffleNumber(int number) {

        List<Integer> list = IntStream.rangeClosed(1, number)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);

        return list;
    }
}
