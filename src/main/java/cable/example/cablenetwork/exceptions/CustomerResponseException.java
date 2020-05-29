package cable.example.cablenetwork.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseException {
    private  String id;
}
