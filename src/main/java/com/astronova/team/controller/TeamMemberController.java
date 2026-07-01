package com.astronova.team.controller;

import com.astronova.team.dto.TeamMemberRequest;
import com.astronova.team.dto.TeamMemberResponse;
import com.astronova.team.service.TeamMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamMemberController {


    private final TeamMemberService teamMemberService;

    @GetMapping("/api/team")
    public List<TeamMemberResponse> getTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("/api/team/{id}")
    public TeamMemberResponse getTeamMember(
            @PathVariable Long id) {
        return teamMemberService.getTeamMemberById(id);
    }

    @PostMapping("/api/admin/team")
    public TeamMemberResponse createTeamMember(
            @Valid
            @RequestBody TeamMemberRequest request) {
        return teamMemberService.createTeamMember(request);
    }

    @PutMapping("/api/admin/team/{id}")
    public TeamMemberResponse updateTeamMember(
            @Valid
            @PathVariable Long id,
            @RequestBody TeamMemberRequest request) {
        return teamMemberService.updateTeamMember(id, request);
    }

    @DeleteMapping("/api/admin/team/{id}")
    public void deleteTeamMember(
            @PathVariable Long id) {
        teamMemberService.deleteTeamMember(id);
    }

    @GetMapping("/api/admin/team")
    public List<TeamMemberResponse> getAllTeamMembersAdmin() {
        return teamMemberService.getAllTeamMembers();
    }

}
