package com.library.library.Classes.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class QPredicates {
    private final List<Predicate> predicates = new ArrayList<>();

    public static QPredicates builder(){
        return new QPredicates();
    }

    public <T> QPredicates add(T object, Function<T, Predicate> fuction){
        if (object != null) {
            predicates.add(fuction.apply(object));
        }
        return this;
    }

    public Predicate buildOr(){
        return Optional.ofNullable(ExpressionUtils.anyOf(predicates)).orElseGet(()->Expressions.asBoolean(true).isTrue());
    }

    public Predicate build(){
        return Optional.ofNullable(ExpressionUtils.allOf(predicates)).orElseGet(()->Expressions.asBoolean(true).isTrue());
    }

}
