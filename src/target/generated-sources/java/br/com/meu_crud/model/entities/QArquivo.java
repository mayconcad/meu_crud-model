package br.com.meu_crud.model.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QArquivo is a Querydsl query type for Arquivo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QArquivo extends EntityPathBase<Arquivo> {

    private static final long serialVersionUID = -862037048;

    public static final QArquivo arquivo = new QArquivo("arquivo");

    public final BooleanPath ativo = createBoolean("ativo");

    public final DateTimePath<java.util.Date> dataRegistro = createDateTime("dataRegistro", java.util.Date.class);

    public final ListPath<Documento, QDocumento> documentos = this.<Documento, QDocumento>createList("documentos", Documento.class, QDocumento.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public QArquivo(String variable) {
        super(Arquivo.class, forVariable(variable));
    }

    public QArquivo(Path<? extends Arquivo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArquivo(PathMetadata<?> metadata) {
        super(Arquivo.class, metadata);
    }

}

