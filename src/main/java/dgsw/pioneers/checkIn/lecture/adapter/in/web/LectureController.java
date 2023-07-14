package dgsw.pioneers.checkIn.lecture.adapter.in.web;

import dgsw.pioneers.checkIn.global.annotation.AuthCheck;
import dgsw.pioneers.checkIn.global.response.Response;
import dgsw.pioneers.checkIn.lecture.adapter.in.web.dto.req.LectureGenerateReq;
import dgsw.pioneers.checkIn.lecture.adapter.in.web.dto.req.WeekPlanUpdateReq;
import dgsw.pioneers.checkIn.lecture.application.port.in.LectureGenerateUseCase;
import dgsw.pioneers.checkIn.global.annotation.WebAdapter;
import dgsw.pioneers.checkIn.lecture.application.port.in.WeekPlanUpdateUseCase;
import dgsw.pioneers.checkIn.member.application.domain.model.Member;
import dgsw.pioneers.checkIn.member.application.domain.model.enums.MemberRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequestMapping(value = "/lecture")
@RequiredArgsConstructor
@Tag(name = "Lecture", description = "Lecture Api")
public class LectureController {

    private final LectureGenerateUseCase lectureGenerateUseCase;
    private final WeekPlanUpdateUseCase weekPlanUpdateUseCase;

    @PostMapping
    @AuthCheck(roles = {MemberRole.ADMIN, MemberRole.TEACHER})
    @Operation(summary = "generate Lecture", description = "강좌 생성")
    public Response generateLecture(
            @RequestAttribute Member member,
            @RequestBody @Valid LectureGenerateReq lectureGenerateReq
    ) {
        lectureGenerateUseCase.generateLecture(member.getMemberId(), lectureGenerateReq);
        return Response.of(HttpStatus.OK, "강좌 생성 성공");
    }

    @PatchMapping("/week-plan")
    @AuthCheck(roles = {MemberRole.ADMIN, MemberRole.TEACHER})
    @Operation(summary = "update week plan", description = "주차 게획 수정")
    public Response updateWeekPlan(
            @RequestAttribute Member member,
            @RequestBody @Valid WeekPlanUpdateReq weekPlanUpdateReq
    ) {
        weekPlanUpdateUseCase.updateWeekPlan(member.getMemberId(), weekPlanUpdateReq);
        return Response.of(HttpStatus.OK, "주차 게획 수정 성공");
    }
}
