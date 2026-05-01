let
  nix-vscode-extensions = import (
    builtins.fetchGit {
      url = "https://github.com/nix-community/nix-vscode-extensions";
      ref = "refs/heads/master";
    }
  );
  pkgs = import <nixpkgs> {
    overlays = [
      nix-vscode-extensions.overlays.default
    ];
  };
  vscodium = pkgs.vscode-with-extensions.override {
    vscode = pkgs.vscodium;
    vscodeExtensions = [
      pkgs.nix-vscode-extensions.open-vsx-release.scalameta.metals
      pkgs.nix-vscode-extensions.open-vsx-release.scala-lang.scala
      pkgs.nix-vscode-extensions.open-vsx-release.jnoortheen.nix-ide
      pkgs.nix-vscode-extensions.open-vsx-release.ltex-plus.vscode-ltex-plus
    ];
  };
in
  pkgs.mkShell {
    packages = [
      pkgs.javaPackages.compiler.openjdk25
      pkgs.ltex-ls-plus
      vscodium
    ];
    setupHook = ''
      rm -rf out/ .bsp/ .metals/
    '';
  }
