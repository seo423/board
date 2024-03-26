package board.board.mapstruct;

import board.board.dto.BoardFileReqDto;
import board.board.dto.BoardReqDto;
import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-26T12:33:03+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class BoardReqMapStructImpl implements BoardReqMapStruct {

    @Override
    public List<BoardEntity> toEntity(List<BoardReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<BoardEntity> list = new ArrayList<BoardEntity>( dtos.size() );
        for ( BoardReqDto boardReqDto : dtos ) {
            list.add( toEntity( boardReqDto ) );
        }

        return list;
    }

    @Override
    public BoardEntity toEntity(BoardReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setBoardIdx( dto.getBoardIdx() );
        boardEntity.setContents( dto.getContents() );
        if ( dto.getCreatedDatetime() != null ) {
            boardEntity.setCreatedDatetime( LocalDateTime.parse( dto.getCreatedDatetime() ) );
        }
        boardEntity.setCreatorId( dto.getCreatorId() );
        boardEntity.setFileList( boardFileReqDtoListToBoardFileEntityCollection( dto.getFileList() ) );
        boardEntity.setHitCnt( dto.getHitCnt() );
        boardEntity.setTitle( dto.getTitle() );
        if ( dto.getUpdatedDatetime() != null ) {
            boardEntity.setUpdatedDatetime( LocalDateTime.parse( dto.getUpdatedDatetime() ) );
        }
        boardEntity.setUpdaterId( dto.getUpdaterId() );

        return boardEntity;
    }

    protected BoardFileEntity boardFileReqDtoToBoardFileEntity(BoardFileReqDto boardFileReqDto) {
        if ( boardFileReqDto == null ) {
            return null;
        }

        BoardFileEntity boardFileEntity = new BoardFileEntity();

        boardFileEntity.setCreatedDatetime( boardFileReqDto.getCreatedDatetime() );
        boardFileEntity.setCreatorId( boardFileReqDto.getCreatorId() );
        boardFileEntity.setFileSize( boardFileReqDto.getFileSize() );
        boardFileEntity.setIdx( boardFileReqDto.getIdx() );
        boardFileEntity.setOriginalFileName( boardFileReqDto.getOriginalFileName() );
        boardFileEntity.setStoredFilePath( boardFileReqDto.getStoredFilePath() );
        boardFileEntity.setUpdatedDatetime( boardFileReqDto.getUpdatedDatetime() );
        boardFileEntity.setUpdaterId( boardFileReqDto.getUpdaterId() );

        return boardFileEntity;
    }

    protected Collection<BoardFileEntity> boardFileReqDtoListToBoardFileEntityCollection(List<BoardFileReqDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<BoardFileEntity> collection = new ArrayList<BoardFileEntity>( list.size() );
        for ( BoardFileReqDto boardFileReqDto : list ) {
            collection.add( boardFileReqDtoToBoardFileEntity( boardFileReqDto ) );
        }

        return collection;
    }
}
