package com.example.kfc.service;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyClubService {

    private final MyClubRepository myClubRepository;

    public MyClub saveClub(MyClub club) {
        return myClubRepository.save(club);
    }

    public List<MyClub> getClubsByUser(UserInfo user) {
        return myClubRepository.findByUser(user);
    }

    public MyClub getClubById(Long clubId) {
        return myClubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found"));
    }

    public void deleteClub(Long clubId) {
        myClubRepository.deleteById(clubId);
    }
    public MyClub updateClub(Long clubId, MyClub request) {
        MyClub existing = getClubById(clubId);
        existing.setName(request.getName());
        return myClubRepository.save(existing);
    }
}
