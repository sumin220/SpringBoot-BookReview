package example.review.domain.dto;

import example.review.domain.entity.Member;
import jakarta.validation.constraints.NotNull;


public record MemberRequest (

        @NotNull
        String name
){
    public Member toEntity() { //빌더타입
        return Member.builder()
                .name(name)
                .build();
    }
}
