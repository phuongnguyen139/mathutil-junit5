
package com.nvxp.mathutil.core;

//import static com.nvxp.mathutil.core.MathUtil.getFactorial;
import static com.nvxp.mathutil.core.MathUtil.*;
//Import static là dành cho những hàm static, gọi hàm bỏ qua Class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTest {
    
    //Chơi DDT, tách data
    
    //Chuẩn bị data
    public static Object[][] initData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData")  //tên hàm cung cấp data và ngầm định thứ tự của mảng.
                                       //và map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(24, getFactorial(4));
//    }
    
    //Bắt ngoại lệ khi đưa data cà chớn
//    @Test (expected = tên ngoại lệ.class) -> JUnit 4 thôi
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //Xài biểu thức lambda
        //Hàm nhận tham số thứ 2 là 1 cái object - có code implement functional interface 
        // tên là Executable - có 1 hàm duy nhất không code
        
        //Chơi chậm
//         Executable exceptionObj = new Executable() {
//             @Override
//             public void execute() throws Throwable {
//                 getFactorial(-5);
//             }
//         };
//        assertThrows(IllegalArgumentException.class, exceptionObj);
        
//        Executable exceptionObj = () -> getFactorial(-5);

        //Chơi nhanh
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
