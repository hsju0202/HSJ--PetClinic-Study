package kr.co.hsj.petclinic.infra.util;

import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class QueryUtils {

    public static <T> BooleanExpression filter(T condition, Function<T, BooleanExpression> function) {
        T temp = condition;

        if (temp instanceof String s && !StringUtils.hasText(s)) {
            temp = null;
        }

        if (temp instanceof List c && CollectionUtils.isEmpty(c)) {
            temp = null;
        }

        return Optional.ofNullable(temp).map(function).orElse(null);
    }

}
