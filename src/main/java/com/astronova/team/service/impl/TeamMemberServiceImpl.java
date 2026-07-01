package com.astronova.team.service.impl;

import com.astronova.exception.ResourceNotFoundException;
import com.astronova.team.dto.TeamMemberRequest;
import com.astronova.team.dto.TeamMemberResponse;
import com.astronova.team.entity.TeamMember;
import com.astronova.team.repository.TeamMemberRepository;
import com.astronova.team.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl
        implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    @Override
    public TeamMemberResponse createTeamMember(
            TeamMemberRequest request) {

        TeamMember member = TeamMember.builder()
                .fullName(request.getFullName())
                .designation(request.getDesignation())
                .bio(request.getBio())
                .imageUrl(request.getImageUrl())
                .linkedinUrl(request.getLinkedinUrl())
                .githubUrl(request.getGithubUrl())
                .active(request.getActive())
                .build();

        return mapToResponse(
                teamMemberRepository.save(member));
    }

    @Override
    public TeamMemberResponse updateTeamMember(
            Long id,
            TeamMemberRequest request) {

        TeamMember member =
                teamMemberRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Team member not found"));

        member.setFullName(request.getFullName());
        member.setDesignation(request.getDesignation());
        member.setBio(request.getBio());
        member.setImageUrl(request.getImageUrl());
        member.setLinkedinUrl(request.getLinkedinUrl());
        member.setGithubUrl(request.getGithubUrl());
        member.setActive(request.getActive());

        return mapToResponse(
                teamMemberRepository.save(member));
    }

    @Override
    public TeamMemberResponse getTeamMemberById(Long id) {

        return mapToResponse(
                teamMemberRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Team member not found")));
    }

    @Override
    public List<TeamMemberResponse> getAllTeamMembers() {

        return teamMemberRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteTeamMember(Long id) {

        TeamMember member =
                teamMemberRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Team member not found"));

        teamMemberRepository.delete(member);
    }

    private TeamMemberResponse mapToResponse(
            TeamMember member) {

        return TeamMemberResponse.builder()
                .id(member.getId())
                .fullName(member.getFullName())
                .designation(member.getDesignation())
                .bio(member.getBio())
                .imageUrl(member.getImageUrl())
                .linkedinUrl(member.getLinkedinUrl())
                .githubUrl(member.getGithubUrl())
                .active(member.getActive())
                .createdAt(member.getCreatedAt())
                .build();
    }

}
