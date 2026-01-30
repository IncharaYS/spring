package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.MemberDTO;
import com.xworkz.Iapp.entity.MemberEntity;
import com.xworkz.Iapp.entity.TeamEntity;
import com.xworkz.Iapp.repository.MemberRepository;
import com.xworkz.Iapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public IssueCode addMember(MemberDTO dto) {

        if (dto == null || dto.getTeamId() <= 0) {
            return IssueCode.INVALIDINPUT;
        }

        Optional<TeamEntity> teamOpt = teamRepository.findById(dto.getTeamId());
        if (!teamOpt.isPresent()) {
            return IssueCode.INVALIDINPUT;
        }

        MemberEntity entity = new MemberEntity();
        entity.setMemberName(dto.getMemberName());
        entity.setMemberEmail(dto.getMemberEmail());
        entity.setRole(dto.getRole());
        entity.setTeam(teamOpt.get());

        boolean saved = memberRepository.save(entity);
        return saved ? IssueCode.ALLOK : IssueCode.DBERROR;
    }

    @Override
    public List<MemberDTO> getMembersByTeam(int teamId) {

        List<MemberEntity> entities = memberRepository.findByTeamId(teamId);
        List<MemberDTO> list = new ArrayList<>();

        for (MemberEntity e : entities) {
            MemberDTO dto = new MemberDTO();
            dto.setMemberId(e.getMemberId());
            dto.setMemberName(e.getMemberName());
            dto.setMemberEmail(e.getMemberEmail());
            dto.setRole(e.getRole());
            dto.setTeamId(e.getTeam().getTeamId());
            list.add(dto);
        }
        return list;
    }


    @Override
    public Optional<MemberDTO> getMemberById(int memberId) {
        Optional<MemberEntity> opt = memberRepository.findById(memberId);
        if (!opt.isPresent()) return Optional.empty();

        MemberEntity e = opt.get();
        MemberDTO dto = new MemberDTO();
        dto.setMemberId(e.getMemberId());
        dto.setMemberName(e.getMemberName());
        dto.setMemberEmail(e.getMemberEmail());
        dto.setRole(e.getRole());
        dto.setTeamId(e.getTeam().getTeamId());
        return Optional.of(dto);
    }

    @Override
    public IssueCode updateMember(MemberDTO dto) {

        Optional<MemberEntity> opt = memberRepository.findById(dto.getMemberId());
        if (!opt.isPresent()) return IssueCode.INVALIDINPUT;

        MemberEntity entity = opt.get();
        entity.setMemberName(dto.getMemberName());
        entity.setMemberEmail(dto.getMemberEmail());
        entity.setRole(dto.getRole());

        return memberRepository.update(entity)
                ? IssueCode.ALLOK
                : IssueCode.DBERROR;
    }

    @Override
    public IssueCode deleteMember(int memberId) {
        return memberRepository.delete(memberId)
                ? IssueCode.ALLOK
                : IssueCode.DBERROR;
    }

}
