package com.sg.oracle.utility.validator;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@Component
@Scope("request")
public class TcknValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println(value.toString());

        if(value.toString().length()!=11)
            throw new ValidatorException(new FacesMessage("T.C.Kimlik Numarası 11 Haneli ve Rakam Olmalıdır."));

        try {
            Long tcKimlikNu = Long.parseLong(value.toString());
        }catch (NumberFormatException ex) {
            throw new ValidatorException(new FacesMessage("T.C.Kimlik Numarası 11 Haneli ve Rakam Olmalıdır."));
        }


        if(!kontrol(value.toString()))
            throw new ValidatorException(new FacesMessage("T.C. Kimlik Numaranız Hatalı"));
    }




    public Map<String, Object> getMetadata() {
        return null;
    }

    public String getValidatorId() {
        return "tcknValidator";
    }


    private static boolean kontrol(String tcNo)
    {
        int[] sayiDizi = parcala(tcNo);

        if (sayiDizi!=null)
        {
            boolean kosul1 = (sayiDizi[0]+sayiDizi[1]+sayiDizi[2]+sayiDizi[3]+sayiDizi[4]+sayiDizi[5]+sayiDizi[6]+sayiDizi[7]+sayiDizi[8]+sayiDizi[9])%10 == sayiDizi[10];
            boolean kosul2 = (((sayiDizi[0]+sayiDizi[2]+sayiDizi[4]+sayiDizi[6]+sayiDizi[8]) * 7 ) + ((sayiDizi[1]+sayiDizi[3]+sayiDizi[5]+sayiDizi[7]) * 9 ))%10 == sayiDizi[9];
            boolean kosul3 = ((sayiDizi[0]+sayiDizi[2]+sayiDizi[4]+sayiDizi[6]+sayiDizi[8]) * 8 )%10 == sayiDizi[10];

            return kosul1 && kosul2 && kosul3;
        }
        return false;
    }

    private static int[] parcala(String tcNo)
    {
        int[] sayilar = new int[11];

        if(tcNo == null || tcNo.length()!=11)
        {
            return null;
        }

        for (int i = 0; i < 11; i++)
        {
            sayilar[i] = Integer.parseInt(tcNo.substring(i,(i+1)));
        }
        return sayilar;
    }
}
