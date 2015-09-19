package jp.mitsuruog.springboot.sample.LeaningSpringDI;

import lombok.Data;

/**
 * Created by mitsuruog on 15/09/19.
 */
// @Dataをつけるとgetter/setter, toString, eqauls, hashCodeが自動生成される
@Data
public class CalculationArgument {
    private final int a;
    private final int b;
}
