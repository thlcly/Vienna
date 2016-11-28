package com.vienna.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tonyhui
 * @since 16/11/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer  id;
    private String   password;
    private String   name;
    private String   phone;
    private String   email;
}
