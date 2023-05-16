package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Runners.BaseTest;
import com.br.spcbrasil.Utils.Instrumentation;

import java.io.IOException;

public class empresasPages extends BaseTest {
    public static void checkResult(String line) throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",line,"Check Message");
    }
}
