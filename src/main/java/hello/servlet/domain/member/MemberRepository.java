package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//실무에서는 ConcurrentHashMap나 AtomicLong 사용을 고려한다.
public class MemberRepository {

    private static Map<Long,Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    //싱글톤으로 만들기
    //싱글톤으로 만들 떄는 private으로 막아야한다.
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        //store의 모든 값들을 ArrayList에 담아서 리턴한다.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}