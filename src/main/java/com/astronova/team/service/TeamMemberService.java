package com.astronova.team.service;

import com.astronova.team.dto.TeamMemberRequest;
import com.astronova.team.dto.TeamMemberResponse;

import java.util.List;

public interface TeamMemberService {

    TeamMemberResponse createTeamMember(
            TeamMemberRequest request);

    TeamMemberResponse updateTeamMember(
            Long id,
            TeamMemberRequest request);

    TeamMemberResponse getTeamMemberById(
            Long id);

    List<TeamMemberResponse> getAllTeamMembers();

    void deleteTeamMember(Long id);

}
