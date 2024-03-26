package board.board.mapstruct;

import board.board.dto.BoardFileResDto;
import board.board.dto.BoardResDto;
import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-26T12:33:04+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class BoardResMapStructImpl implements BoardResMapStruct {

    @Override
    public List<BoardResDto> toDto(List<BoardEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BoardResDto> list = new ArrayList<BoardResDto>( entities.size() );
        for ( BoardEntity boardEntity : entities ) {
            list.add( toDto( boardEntity ) );
        }

        return list;
    }

    @Override
    public BoardResDto toDto(BoardEntity entiy) {
        if ( entiy == null ) {
            return null;
        }

        BoardResDto boardResDto = new BoardResDto();

        boardResDto.setBoardIdx( entiy.getBoardIdx() );
        boardResDto.setContents( entiy.getContents() );
        if ( entiy.getCreatedDatetime() != null ) {
            boardResDto.setCreatedDatetime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entiy.getCreatedDatetime() ) );
        }
        boardResDto.setCreatorId( entiy.getCreatorId() );
        boardResDto.setFileList( boardFileEntityCollectionToBoardFileResDtoList( entiy.getFileList() ) );
        boardResDto.setHitCnt( entiy.getHitCnt() );
        boardResDto.setTitle( entiy.getTitle() );
        if ( entiy.getUpdatedDatetime() != null ) {
            boardResDto.setUpdatedDatetime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entiy.getUpdatedDatetime() ) );
        }
        boardResDto.setUpdaterId( entiy.getUpdaterId() );

        return boardResDto;
    }

    protected BoardFileResDto boardFileEntityToBoardFileResDto(BoardFileEntity boardFileEntity) {
        if ( boardFileEntity == null ) {
            return null;
        }

        BoardFileResDto boardFileResDto = new BoardFileResDto();

        boardFileResDto.setCreatedDatetime( boardFileEntity.getCreatedDatetime() );
        boardFileResDto.setCreatorId( boardFileEntity.getCreatorId() );
        boardFileResDto.setFileSize( boardFileEntity.getFileSize() );
        boardFileResDto.setIdx( boardFileEntity.getIdx() );
        boardFileResDto.setOriginalFileName( boardFileEntity.getOriginalFileName() );
        boardFileResDto.setStoredFilePath( boardFileEntity.getStoredFilePath() );
        boardFileResDto.setUpdatedDatetime( boardFileEntity.getUpdatedDatetime() );
        boardFileResDto.setUpdaterId( boardFileEntity.getUpdaterId() );

        return boardFileResDto;
    }

    protected List<BoardFileResDto> boardFileEntityCollectionToBoardFileResDtoList(Collection<BoardFileEntity> collection) {
        if ( collection == null ) {
            return null;
        }

        List<BoardFileResDto> list = new ArrayList<BoardFileResDto>( collection.size() );
        for ( BoardFileEntity boardFileEntity : collection ) {
            list.add( boardFileEntityToBoardFileResDto( boardFileEntity ) );
        }

        return list;
    }
}
