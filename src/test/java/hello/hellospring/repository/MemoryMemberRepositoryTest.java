package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afferEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save( member );

        //Member result = repository.findById( member.getId() ).get();
        Member result = repository.findById( member.getId() ).orElse( null );
        assertThat( member ).isEqualTo( result );
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");
        repository.save( member );

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save( member1 );

        Member result = repository.findByName( "spring1" ).get();

        assertThat( result ).isEqualTo( member );
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName( "spring1" );
        member2.setName( "spring2" );
        repository.save( member1 );
        repository.save( member2 );

        List<Member> result = repository.findAll();

        assertThat( result.size() ).isEqualTo( 2 );
    }
}

