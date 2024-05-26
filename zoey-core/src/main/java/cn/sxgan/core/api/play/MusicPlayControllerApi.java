package cn.sxgan.core.api.play;

import cn.sxgan.common.entity.vo.RecommendVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 * @Description: 音乐播放控制器接口
 * @Author: sxgan
 * @Date: 2024-05-20 22:47
 * @Version: 1.0
 **/

public interface MusicPlayControllerApi {
    
    @Operation(summary = "音乐播放流", description = "获取指定音乐的播放流",
            responses = {
                    @ApiResponse(
                            description = "返回指定音乐的播放流",
                            content = @Content(
                                    mediaType = "audio/mpeg",
                                    schema = @Schema(implementation = RecommendVO.class))),
                    @ApiResponse(responseCode = "700~1000", description = "系统业务错误")
            })
    public ResponseEntity<Resource> getPlayMusicStream(String path);
}
