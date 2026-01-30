package com.xworkz.Iapp.service;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    IssueCode addMember(MemberDTO dto);

    List<MemberDTO> getMembersByTeam(int teamId);

    Optional<MemberDTO> getMemberById(int memberId);

    IssueCode updateMember(MemberDTO dto);

    IssueCode deleteMember(int memberId);
}

