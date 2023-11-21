package py.com.softshop.factorial.service.imp;

import org.springframework.stereotype.Service;
import py.com.softshop.factorial.exception.FactorialException;
import py.com.softshop.factorial.model.Factorial;
import py.com.softshop.factorial.service.FactorialService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FactorialServiceImp implements FactorialService {
    @Override
    public List<Factorial> getFactorial(Integer hasta) throws FactorialException {
        try {

            List<Factorial> factorialList = new ArrayList<>();
            int to = hasta != null ? hasta : 1000;
            for (int i = 1; i <= to; i++) {
                BigInteger resultadoFactorial = calculateFactorial(i);
                Factorial factorial = new Factorial();
                factorial.setNumero(i);
                factorial.setResultado("Factorial of " + i + ": " + resultadoFactorial);
                factorialList.add(factorial);
                System.out.println("Factorial of " + i + ": " + resultadoFactorial);
            }

            return factorialList;
        } catch (Exception exception) {
            throw new FactorialException(exception.getMessage());
        }

    }

    private BigInteger calculateFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
