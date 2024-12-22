package common.module.jpa;

import common.module.webmvc.CurrentUser;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@EntityScan
@ComponentScan
public class JpaConfiguration {
//    @Bean
//    @ConditionalOnWebApplication
//    public AuditorAware<String> jpaAuditor() {
//        return new AuditorAware<>() {
//            @Autowired
//            private CurrentUser currentUser;
//
//            @Override
//            public Optional<String> getCurrentAuditor() {
//                String auditor = "anonymous";
//                try {
//                    return Optional.ofNullable(currentUser)
//                            .map(CurrentUser::getEmail)
//                            .or(() -> Optional.of(auditor));
//                } catch (BeanCreationException e) {
//                    // ignored
//                    return Optional.of(auditor);
//                }
//            }
//        };
//    }
}
