package cn.sxgan.admin.api.file;

import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传控制器API
 * @Author: sxgan
 * @Date: 2024-05-31 20:08
 * @Version: 1.0
 **/
@Tag(name = "文件管理API", description = "文件管理")
public interface UploadFileControllerApi {
    @Operation(summary = "上传单个文件", description = "上传单个文件",
            parameters = {
                    @Parameter(name = "file", description = "文件对象", content = @Content(mediaType = "multipart/form-data", schema = @Schema(contentSchema = MultipartFile.class)))
            },
            responses = {
                    @ApiResponse(description = "返回上传结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<String> uploadSingleFile(MultipartFile file);
    
    @Operation(summary = "上传歌曲文件进行处理", description = "上传歌曲文件进行处理",
            parameters = {
                    @Parameter(name = "file", description = "文件对象", content = @Content(mediaType = "multipart/form-data", schema = @Schema(contentSchema = MultipartFile.class)))
            },
            responses = {
                    @ApiResponse(description = "返回上传解析结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MusicSongVO.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<MusicSongVO> songFileUploadApi(MultipartFile file);
}
