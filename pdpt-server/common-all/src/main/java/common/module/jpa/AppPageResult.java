package common.module.jpa;

import com.google.common.collect.Lists;
import common.module.util.AppJsons;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@Accessors(chain = true)
public class AppPageResult<T> {

    private Long totalElements;
    private List<T> content;

    public static <T> AppPageResult<T> of(Long totalElements, List<T> content) {
        return new AppPageResult<T>()
                .setTotalElements(totalElements)
                .setContent(content);
    }

    public static <T> AppPageResult<T> of(Page<T> page) {
        AppPageResult<T> appPageResult = new AppPageResult<>();
        AppBeans.copyProperties(page, appPageResult);
        return appPageResult;
    }

    public <C> AppPageResult<C> convert(Class<C> tClass) {
        AppPageResult<C> page = new AppPageResult<>();
        AppBeans.copyProperties(this, page);
        page.content = AppJsons.convertList(this.content, tClass);
        return page;
    }

    public <C> AppPageResult<C> map(Function<T, C> func) {
        AppPageResult<C> page = new AppPageResult<>();
        AppBeans.copyProperties(this, page);
        page.content = this.content.stream().map(func).collect(Collectors.toList());
        return page;
    }

    public static <C> AppPageResult<C> empty() {
        return AppPageResult.of(0L, Lists.newArrayList());
    }

    public AppPageResult<T> wrapContent(Consumer<List<T>> consumer) {
        consumer.accept(content);
        return this;
    }

}
