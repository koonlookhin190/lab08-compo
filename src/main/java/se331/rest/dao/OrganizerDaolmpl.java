package se331.rest.dao;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaolmpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(111L)
                .organizerName("Hin Krit")
                .address("Chiang Mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(222L)
                .organizerName("JoJo Yasintorn")
                .address("Chiang Mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(333L)
                .organizerName("Poom Nitipoom")
                .address("Chiang Mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(444L)
                .organizerName("Sin Paduakkiat")
                .address("Chiang Mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(555L)
                .organizerName("Mark Mark")
                .address("Chiang Mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(666L)
                .organizerName("Jame Jame")
                .address("Chiang Mai")
                .build());
    }

        @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize ==null?organizerList.size():pageSize;
        page = page ==null?1:page;
        Integer firstIndex = (page-1)*pageSize;
        return  organizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
