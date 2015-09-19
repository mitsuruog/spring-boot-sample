package jp.mitsuruog.springboot.sample.LeaningSpringDI;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Component
public class ScannerCalculationArgumentResolver implements ArgumentResolver {
    @Override
    public CalculationArgument resolve(InputStream stream) {
        Scanner scanner = new Scanner(stream);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        return new CalculationArgument(a, b);
    }
}
