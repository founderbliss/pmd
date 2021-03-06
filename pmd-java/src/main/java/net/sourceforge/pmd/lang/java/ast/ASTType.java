/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTType.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTType extends AbstractJavaTypeNode {
    public ASTType(int id) {
        super(id);
    }

    public ASTType(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public String getTypeImage() {
        ASTPrimitiveType prim = getFirstDescendantOfType(ASTPrimitiveType.class);
        if (prim != null) {
            return prim.getImage();
        }
        return getFirstDescendantOfType(ASTClassOrInterfaceType.class).getImage();
    }

    public int getArrayDepth() {
        if (jjtGetNumChildren() != 0 && (jjtGetChild(0) instanceof ASTReferenceType || jjtGetChild(0) instanceof ASTPrimitiveType)) {
            return ((Dimensionable) jjtGetChild(0)).getArrayDepth();
        }
        throw new RuntimeException("ASTType.getArrayDepth called, but first child (of " + jjtGetNumChildren() + " total children) is neither a primitive nor a reference type.");
    }

    public boolean isArray() {
        return getArrayDepth() > 0;
    }


}
