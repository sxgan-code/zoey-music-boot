package cn.sxgan.core.api.online;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.RecommendVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * @Description: 推荐页Api
 * @Author: sxgan
 * @Date: 2024-05-08 21:03
 * @Version: 1.0
 **/
@Tag(name = "推荐页Api", description = "在线模块推荐功能API")
public interface IRecommendControllerApi {
    @Operation(summary = "今日推荐", description = "今日推荐接口",
            responses = {
                    @ApiResponse(
                            description = "返回今日推荐数据",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RecommendVO.class))),
                    @ApiResponse(responseCode = "700~1000", description = "系统业务错误")
            })
    ResponseResult<RecommendVO> getTodayRecommend();
    
    @Operation(summary = "私荐歌单", description = "推荐页私荐歌单获取",
            responses = {
                    @ApiResponse(
                            description = "返回推荐页私荐歌单获取",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class))),
                    @ApiResponse(responseCode = "700~1000", description = "系统业务错误")
            })
    ResponseResult<List<MusicListVO>> getRecommendPrivateMusicList();
}
