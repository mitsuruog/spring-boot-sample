package jp.mitsuruog.springboot.sample.LeaningSpringDI;

import java.io.InputStream;

/**
 * Created by mitsuruog on 15/09/19.
 */
public interface ArgumentResolver {
    CalculationArgument resolve(InputStream stream);
}
