package academy.zigee.repository;

import academy.zigee.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MemberDaoServcie {

    private static List<Member> members = new ArrayList<>();

    private static int memberCount = 3;

    static {
        members.add(new Member(1,
                        "허혜인",
                        "KAKAO",
                        "https://cdn.pixabay.com/photo/2022/10/18/06/57/cat-7529439_1280.jpg",
                "USER",
                new Date(),
                new Date()));

        members.add(new Member(2,
                "임해인",
                "KAKAO",
                "https://cdn.pixabay.com/photo/2025/09/12/16/42/dog-9830813_1280.jpg",
                "USER",
                new Date(),
                new Date()));

        members.add(new Member(3,
                "홍길동",
                "KAKAO",
                "https://cdn.pixabay.com/photo/2024/05/22/21/51/dog-8781844_1280.jpg",
                "USER",
                new Date(),
                new Date()));
    }

    public List<Member> findAll() {
        return members;
    }


    public Member save(Member member) {
        if (member.getId() == null) {
            member.setId(++memberCount);
        }

        members.add(member);

        return member;
    }

    public Member findOne(int id) {
        for (Member member : members) {
            if(member.getId() == id) {
                return member;
            }
        }

        return null;
    }
}
