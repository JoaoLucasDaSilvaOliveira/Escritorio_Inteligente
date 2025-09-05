package org.escinteligente.escritorio_inteligente.Model;

import org.jetbrains.annotations.NotNull;

public record Empresa (int id, String cnpj, String nome, boolean vars, boolean temProlabore, String tipoFolha, String tipoEnvio, String nomeDono, String fone) {
}
