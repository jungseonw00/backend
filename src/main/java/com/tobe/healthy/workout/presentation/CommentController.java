package com.tobe.healthy.workout.presentation;

import com.tobe.healthy.common.CommonService;
import com.tobe.healthy.common.ResponseHandler;
import com.tobe.healthy.config.security.CustomMemberDetails;
import com.tobe.healthy.member.domain.entity.Member;
import com.tobe.healthy.workout.application.CommentService;
import com.tobe.healthy.workout.domain.dto.WorkoutHistoryCommentDto;
import com.tobe.healthy.workout.domain.dto.in.HistoryCommentAddCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "comment", description = "운동기록 댓글 API")
@Slf4j
public class CommentController {

    private final CommonService commonService;
    private final CommentService commentService;

    @Operation(summary = "운동기록 댓글 조회", responses = {
            @ApiResponse(responseCode = "400", description = "잘못된 요청 입력"),
            @ApiResponse(responseCode = "200", description = "운동기록의 댓글, 페이징을 반환한다.")
    })
    @GetMapping("/workout-histories/{workoutHistoryId}/comments")
    public ResponseHandler<List<WorkoutHistoryCommentDto>> getCommentsByHistoryId(@PathVariable("workoutHistoryId") Long workoutHistoryId,
                                                                                 Pageable pageable) {
        return ResponseHandler.<List<WorkoutHistoryCommentDto>>builder()
                .statusCode(HttpStatus.OK)
                .data(commentService.getCommentsByWorkoutHistoryId(workoutHistoryId, pageable))
                .message("댓글이 조회되었습니다.")
                .build();
    }

    @Operation(summary = "운동기록 댓글(답글) 등록", responses = {
            @ApiResponse(responseCode = "400", description = "잘못된 요청 입력"),
            @ApiResponse(responseCode = "200", description = "운동기록 댓글을 반환한다.")
    })
    @PostMapping("/workout-histories/{workoutHistoryId}/comments")
    public ResponseHandler<WorkoutHistoryCommentDto> addComment(@AuthenticationPrincipal CustomMemberDetails customMemberDetails,
                                                                @PathVariable("workoutHistoryId") Long workoutHistoryId,
                                                                @Valid HistoryCommentAddCommand command) {
        return ResponseHandler.<WorkoutHistoryCommentDto>builder()
                .statusCode(HttpStatus.OK)
                .data(commentService.addComment(workoutHistoryId, command, customMemberDetails.getMember()))
                .message("댓글이 등록되었습니다.")
                .build();
    }

    @Operation(summary = "운동기록 댓글 수정", responses = {
            @ApiResponse(responseCode = "400", description = "잘못된 요청 입력"),
            @ApiResponse(responseCode = "200", description = "운동기록 댓글을 반환한다.")
    })
    @PutMapping("/workout-histories/{workoutHistoryId}/comments/{commentId}")
    public ResponseHandler<WorkoutHistoryCommentDto> updateComment(@AuthenticationPrincipal CustomMemberDetails customMemberDetails,
                                                                  @PathVariable("workoutHistoryId") Long workoutHistoryId,
                                                                  @PathVariable("commentId") Long commentId,
                                                                  @Valid HistoryCommentAddCommand command) {
        return ResponseHandler.<WorkoutHistoryCommentDto>builder()
                .statusCode(HttpStatus.OK)
                .data(commentService.updateComment(customMemberDetails.getMember(), workoutHistoryId, commentId, command))
                .message("댓글이 수정되었습니다.")
                .build();
    }

    @Operation(summary = "운동기록 댓글 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "운동기록 댓글 삭제 완료.")
    })
    @PatchMapping("/workout-histories/{workoutHistoryId}/comments/{commentId}")
    public ResponseHandler<?> deleteComment(@AuthenticationPrincipal CustomMemberDetails customMemberDetails,
                                           @PathVariable("workoutHistoryId") Long workoutHistoryId,
                                           @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(customMemberDetails.getMember(), workoutHistoryId, commentId);
        return ResponseHandler.builder()
                .statusCode(HttpStatus.OK)
                .message("댓글이 삭제되었습니다.")
                .build();
    }

}
