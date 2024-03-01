package fes.aragon.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Core {

    private List<String> sources;
    private List<Boolean> responses;


    public Core(List<String> sources) {
        this.sources = sources;
        this.responses = new ArrayList<>();
    }

    public List<Boolean> resolveSources() throws Exception {
        if(this.sources.isEmpty()){
            throw new Exception();
        }

        this.sources.stream().forEach(source -> {
            // initial state
            int state = 0;
            int errorCol = -1;
            boolean error = false;

            for (int i = 0; i <= source.length() - 1; i++) {
                char c = source.charAt(i);

                if(c != '0' && c != '1') {
                    error = true;
                    errorCol = i;
                    break;
                };

                switch (state) {
                    case 0:
                        if (c == '1') state = 0;
                        else if (c == '0') state = 1;
                        break;
                    case 1:
                        if (c == '1') state = 1;
                        else if (c == '0') state = 0;
                        break;
                }
            }

            if (state == 1 && !error) this.responses.add(true);
            else {
                this.responses.add(false);
                if(error && errorCol >= 0) System.out.printf("Invalid character at column %d",errorCol);
            };
        });

        return this.responses;
    }
}
