package br.com.meu_crud.model.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QDocumento is a Querydsl query type for Documento
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDocumento extends EntityPathBase<Documento> {

    private static final long serialVersionUID = -1086734065;

    public static final QDocumento documento = new QDocumento("documento");

    public final ArrayPath<Byte> conteudo = createArray("conteudo", Byte[].class);

    public final DateTimePath<java.util.Date> dataRegistro = createDateTime("dataRegistro", java.util.Date.class);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigDecimal> tamanho = createNumber("tamanho", java.math.BigDecimal.class);

    public final EnumPath<br.com.meu_crud.model.enums.TipoDocEnum> tipo = createEnum("tipo", br.com.meu_crud.model.enums.TipoDocEnum.class);

    public final StringPath titulo = createString("titulo");

    public QDocumento(String variable) {
        super(Documento.class, forVariable(variable));
    }

    public QDocumento(Path<? extends Documento> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDocumento(PathMetadata<?> metadata) {
        super(Documento.class, metadata);
    }

}

