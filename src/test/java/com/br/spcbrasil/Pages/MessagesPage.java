package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Instrumentation;

import java.io.IOException;

public class MessagesPage extends BaseStep {

    public static void checkMessage(String arg0) throws IOException {
        Instrumentation.clickByClassText_Android(driver,"android.widget.TextView",arg0,"Check Message");
    }
}
