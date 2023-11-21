package py.com.softshop.factorial.service;

import py.com.softshop.factorial.exception.FactorialException;
import py.com.softshop.factorial.model.Factorial;

import java.util.List;

public interface FactorialService {
    public List<Factorial> getFactorial(Integer hasta) throws FactorialException;
}
