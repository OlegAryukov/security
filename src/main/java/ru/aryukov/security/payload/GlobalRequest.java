package ru.aryukov.security.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GlobalRequest {
	
	Object request;

}
